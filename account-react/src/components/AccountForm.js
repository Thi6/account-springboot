import React, { Component } from 'react';
import axios from 'axios';


export default class AccountForm extends Component {
    constructor() {
        super();

        this.state = {
            prize: ""
        };
    }

    createAccount = (event) => {
        event.preventDefault();
        
        let newItem = {
            firstname: event.target[0].value,
            lastname: event.target[1].value
        }

        axios
            .post("http://localhost:8080/account/create", newItem)
            .then(response => {

                this.setState({
                    prize: response.data.prize
                })

            }).catch(err => console.log(err))
    }

    render() {
        return (
            <div>
                <h1>Account</h1>

                <form onSubmit={this.createAccount}>
                    <input id="firstname" type="text" placeholder="First Name"></input>
                    <br></br>
                    <input id="lastname" type="text" placeholder="Last Name"></input>
                    <br></br>
                    <button type="submit">Create</button>
                </form>

                
                <p>{this.state.prize}</p>
                
            </div>
        )

    }

}