import { useRouter } from 'next/router';
import { useForm } from 'react-hook-form';
export default create;
import {useEffect, useState} from 'react';


function create() {
    const router = useRouter();
    const { register, handleSubmit, formState} = useForm();
    const [opportunities, setOpportunities] = useState();
    const { errors } = formState;

    const getApiData = async () => {
      const response = await fetch(
        "http://localhost:8080/api/v1/opportunities"
      ).then((response) => response.json());
    
      // update the state
      setOpportunities(response);
      }

    useEffect(() => {
      getApiData();

    }, []);

    function onSubmit({date,type,opportunity}) {
      
      

      const requestOptions = {
        method: 'POST',
        headers:{'Content-Type':'application/json'},
        body: JSON.stringify(
          {
            "date":date,
            "type":type,
            "opportunity":opportunity
          }
        )
  
      };
          fetch('http://localhost:8080/api/v1/contacts',requestOptions)
            .then((data) => {
              console.log(data);
              if(data.status==200){
                router.push('/posts/dashboard');
               } 
              })
    }
    console.log(opportunities)
    if(opportunities){

    
    return (
        
            <div className="card">
                <h4 className="card-header">Create a new Contact</h4>
                <div className="card-body">
                    <form onSubmit={handleSubmit(onSubmit)}>
                        <div className="form-group">
                            <label>Date </label>
                            <input name="date" type="date" {...register('date')} className={`form-control ${errors.date ? 'is-invalid' : ''}`} />
                        </div>
                        <div className="form-group">
                            <label>Type </label>
                            <input name="type" type="text" {...register('type')} className={`form-control ${errors.type ? 'is-invalid' : ''}`} />
                        </div>

                        <button disabled={formState.isSubmitting} className="btn btn-primary">
                            {formState.isSubmitting && <span className="spinner-border spinner-border-sm mr-1"></span>}
                            Create
                        </button>
                      
                        <select name="opportunity" form="opportunity">
                        {opportunities.map((opportunity) => (
                          <option value={opportunity.id}>{opportunity.id}</option>
                        ))}
                        </select>
                    </form>
                          
                </div>
            </div>
       
    );
    }else{
      return(
        <h1>No va</h1>
      );
    }
}