import React, {Component} from 'react';
import {BrowserRouter} from 'react-router-dom';
import axios from 'axios';
import qs from 'qs';

class ShipData extends Component {

    constructor(props) {
        super(props);
        this.state = {
            satellites : props.location.state.satellites,
            shipData: {}
        }
    }

    componentDidMount() {
        this.state.satellites[0].distance = parseFloat(this.state.satellites[0].distance);
        this.state.satellites[1].distance = parseFloat(this.state.satellites[1].distance);
        this.state.satellites[2].distance = parseFloat(this.state.satellites[2].distance);
        const options = {
            method: 'POST',
            headers: { 'content-type': 'application/json' },
            data: this.state,
            url: 'http://localhost:8080/topsecret'
        };
        axios(options)
            .then((response) => {this.state.shipData = response;})
            .catch(error => {
                console.log( 'the error has occured: ' + error);
                this.setState({
                    shipData: error.response.data
                })
            })
    }

    render(){
        return (
            <>
                {this.state.shipData.position == null ? <p>La position es null</p> : <p>The position is: {this.state.shipData.position}</p>}
                {this.state.shipData.message == null ? <p>El message es null</p> : <p>The message is: {this.state.shipData.message}</p>}
            </>
        )
    }

}

export default ShipData;
