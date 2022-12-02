import Link from 'next/link';
import {useEffect, useState} from 'react';
import Calendar from 'react-calendar';

import { useRouter } from 'next/router';


export default function detail() {
    const [contact, setContact] = useState();
    const router = useRouter()
    const {id} = router.query;

    const getApiData = async () => {
          const response = await fetch(
          "http://localhost:8080/api/v1/contacts/"+id
        ).then((response) => response.json())
        .then((res)=>setContact(res));
        }

      useEffect(() => {
        getApiData();

      }, []);

      
  if(contact){

  return (  
    <>
     <div>
      <h1>Contact Detail</h1>
      <div className="app">
                <div className="item-container">
            Id: {contact.id} Date: {contact.date} Type: {contact.type} Accepted? {contact.accepted.toString()} Reason: {contact.reason}
                     </div>
        </div>
      </div>
      <h2>
        <Link href="/posts/dashboard">Back to home</Link>
      </h2>
    </>
  );
}else{
  <h1>No va</h1>
}

}
