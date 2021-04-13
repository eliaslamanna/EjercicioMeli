import React, {Component} from 'react';
import {BrowserRouter} from 'react-router-dom';

class ShipData extends Component {

    constructor(props) {
        const satellites = props.location.state.satellites;
        super(props);
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
