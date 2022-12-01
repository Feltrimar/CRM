import Head from 'next/head'
import styles from '../styles/Home.module.css';
import Link from 'next/link';
import { useRouter } from 'next/router';
import { useForm } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';
import * as Yup from 'yup';

export default Login;

function Login() {
    const router = useRouter();

    

    // get functions to build form with useForm() hook
    const { register, handleSubmit, formState } = useForm();
    const { errors } = formState;

    function onSubmit({ userName, password }) {
      const requestOptions = {
        method: 'POST',
        headers:{'Content-Type':'application/json'},
        body: JSON.stringify(
          {
            "userName":userName,
            "password":password,
          }
        )
  
      };
          fetch('http://localhost:8080/api/v1/users',requestOptions)
            .then(((res) => res.json))
    }

    return (
        
            <div className="card">
                <h4 className="card-header">Login</h4>
                <div className="card-body">
                    <form onSubmit={handleSubmit(onSubmit)}>
                        <div className="form-group">
                            <label>UserName</label>
                            <input name="userName" type="text" {...register('userName')} className={`form-control ${errors.userName ? 'is-invalid' : ''}`} />
                            <div className="invalid-feedback">{errors.userName?.message}</div>
                        </div>
                        <div className="form-group">
                            <label>Password</label>
                            <input name="password" type="password" {...register('password')} className={`form-control ${errors.password ? 'is-invalid' : ''}`} />
                            <div className="invalid-feedback">{errors.password?.message}</div>
                        </div>
                        <button disabled={formState.isSubmitting} className="btn btn-primary">
                            {formState.isSubmitting && <span className="spinner-border spinner-border-sm mr-1"></span>}
                            Login
                        </button>
                    </form>
                </div>
            </div>
       
    );
}