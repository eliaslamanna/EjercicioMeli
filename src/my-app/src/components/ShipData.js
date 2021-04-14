import React, {Component} from 'react';
import {BrowserRouter} from 'react-router-dom';
import axios from 'axios';
import qs from 'qs';

class ShipData extends Component {

    constructor(props) {
        super(props);
        this.state = {
            satellites : props.location.state.satellites
        }
    }

    componentDidMount() {
        this.state.satellites[0].distance = parseFloat(this.state.satellites[0].distance);
        this.state.satellites[1].distance = parseFloat(this.state.satellites[1].distance);
        this.state.satellites[2].distance = parseFloat(this.state.satellites[2].distance);
        console.log(this.state.satellites);
        const options = {
            method: 'POST',
            headers: { 'content-type': 'application/json' },
            data: this.state,
            url: 'http://localhost:8080/topsecret'
        };
        axios(options)
            .then((response) => {console.log(response)})
            .catch(error => {console.log( 'the error has occured: ' + error) })

    }

    render(){
        return (
            <>
            <div>
                <p>Cambio de componente</p>
            </div>
            </>
        )
    }

}

export default ShipData;
