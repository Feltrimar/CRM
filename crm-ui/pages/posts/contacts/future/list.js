import Link from 'next/link';
import {useEffect, useState} from 'react';
import Calendar from 'react-calendar';
import { useRouter } from 'next/router';



export default function list() {
    const [contacts, setContacts] = useState();
    const router = useRouter();
    const getApiData = async () => {
        const response = await fetch(
          "http://localhost:8080/api/v1/contacts/future"
        ).then((response) => response.json());
      
        // update the state
        setContacts(response);
        }

      useEffect(() => {
        getApiData();

      }, []);

      
  
  return (  
    <>
     <div>
      <h1>List of Contacts</h1>
      <div className="app">
            {contacts &&
                contacts.map((contact) => (
                <div className="item-container">
                    Id: {contact.id} Type: {contact.type} Accepted? {contact.accepted.toString()}
                    <Link
            href={{
              pathname: '/posts/contacts/detail/[id]',
              query: { id: contact.id },
            }}
          >
                    <button>
                      Details
                    </button></Link>
                </div>
            ))}
        </div>
      </div>
      <h2>
        <Link href="/posts/dashboard">Back to home</Link>
      </h2>
      <div/>
      <Link
          href={{
            pathname: '/posts/contacts/create'
          }}
        >
                  <button>
                    Create new contact
                  </button></Link>
    </>
  )
}

