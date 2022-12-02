import Link from 'next/link';
import {useEffect, useState} from 'react';
import Calendar from 'react-calendar';

import { useRouter } from 'next/router';


export default function detail() {
    const [opportunity, setOpportunity] = useState();
    const router = useRouter()
    const {id} = router.query;

    const getApiData = async () => {
          const response = await fetch(
          "http://localhost:8080/api/v1/opportunities/"+id
        ).then((response) => response.json())
        .then((res)=>setOpportunity(res));
        }

      useEffect(() => {
        getApiData();

      }, []);

      
  if(opportunity){

  return (  
    <>
     <div>
      <h1>Opportunity Detail</h1>
      <div className="app">
                <div className="item-container">
                {opportunity.name} {opportunity.surname} has email: {opportunity.email}, telephone: {opportunity.telephone}
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
