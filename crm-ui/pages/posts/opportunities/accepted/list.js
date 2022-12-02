import Link from 'next/link';
import {useEffect, useState} from 'react';
import Calendar from 'react-calendar';
import { useRouter } from 'next/router';


export default function list() {
  const [opportunities, setOpportunities] = useState();
  const router = useRouter();
  const getApiData = async () => {
      const response = await fetch(
        "http://localhost:8080/api/v1/opportunities/customers"
      ).then((response) => response.json());
    
      // update the state
      setOpportunities(response);
      }

    useEffect(() => {
      getApiData();

    }, []);

    

return (  
  <>
   <div>
    <h1>List of Opportunities</h1>
    <div className="app">
          {opportunities &&
              opportunities.map((opportunity) => (
              <div className="item-container">
                  {opportunity.name} {opportunity.surname}
                  <Link
          href={{
            pathname: '/posts/opportunities/detail/[id]',
            query: { id: opportunity.id },
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
            pathname: '/posts/opportunities/create'
          }}
        >
                  <button>
                    Create new opportunity
                  </button></Link>
  </>
)
}