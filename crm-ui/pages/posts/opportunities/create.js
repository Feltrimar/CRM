import { useRouter } from 'next/router';
import { useForm } from 'react-hook-form';
export default Create;

function Create() {
    const router = useRouter();
    const { register, handleSubmit, formState } = useForm();
    const { errors } = formState;

    function onSubmit({ name,surname,email,telephone,customer}) {
      
      const requestOptions = {
        method: 'POST',
        headers:{'Content-Type':'application/json'},
        body: JSON.stringify(
          {
            "name":name,
            "surname":surname,
            "email":email,
            "telephone":telephone,
            "customer":customer
          }
        )
  
      };
          fetch('http://localhost:8080/api/v1/opportunities',requestOptions)
            .then((data) => {
              console.log(data);
              if(data.status==200){
                router.push('/posts/dashboard');
               } 
              })
    }

    return (
        
            <div className="card">
                <h4 className="card-header">Create Opportunity</h4>
                <div className="card-body">
                    <form onSubmit={handleSubmit(onSubmit)}>
                        <div className="form-group">
                            <label>Name</label>
                            <input name="name" type="text" {...register('name')} className={`form-control ${errors.name ? 'is-invalid' : ''}`} />
                        </div>
                        <div className="form-group">
                            <label>Surname</label>
                            <input name="surname" type="surname" {...register('surname')} className={`form-control ${errors.surname ? 'is-invalid' : ''}`} />
                        </div>

                        <div className="form-group">
                            <label>email</label>
                            <input name="email" type="email" {...register('email')} className={`form-control ${errors.email ? 'is-invalid' : ''}`} />
                        </div>

                        <div className="form-group">
                            <label>telephone</label>
                            <input name="telephone" type="telephone" {...register('telephone')} className={`form-control ${errors.telephone ? 'is-invalid' : ''}`} />
                        </div>

                        <div className="form-group">
                            <label>Is a Customer?</label>
                            <input name="customer" type="radio" {...register('customer')} className={`form-control ${errors.customer ? 'is-invalid' : ''}`} />
                        </div>

                        <button disabled={formState.isSubmitting} className="btn btn-primary">
                            {formState.isSubmitting && <span className="spinner-border spinner-border-sm mr-1"></span>}
                            Create
                        </button>
                    </form>
                </div>
            </div>
       
    );
}