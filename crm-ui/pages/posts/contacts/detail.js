import Link from 'next/link';
import {useEffect, useState} from 'react';
import Calendar from 'react-calendar';



export default function Detail() {
    const [contact, setContact] = useState();

    const getApiData = async () => {
        const response = await fetch(
          "http://localhost:8080/api/v1/contacts/"
        ).then((response) => response.json());
      
        // update the state
        setContact(response);
        }

      useEffect(() => {
        getApiData();

      }, []);

      
  
  return (  
    <>
     <div>
      <h1>Contact Detail</h1>
      <div className="app">
            {contacts &&
                contacts.map((contact) => (
                <div className="item-container">
                    Id: {contact.id} Date: {contact.date} Type: {contact.type} Accepted? {contact.accepted.toString()} Reason: {contact.reason} 
                </div>
            ))}
        </div>
      </div>
      <h2>
        <Link href="/posts/dashboard">Back to home</Link>
      </h2>
    </>
  );
}