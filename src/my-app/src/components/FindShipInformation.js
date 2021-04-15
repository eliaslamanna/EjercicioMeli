import React, {useState} from 'react';
import {Link, Router} from 'react-router-dom';
import { useHistory } from "react-router-dom";

function FindShipInformation() {

    const[kenobi,setEstadoKenobi] = useState({
        name:'Kenobi',
        distance: '',
        message: []
    })

    const[skywalker,setEstadoSkywalker] = useState({
        name: 'Skywalker',
        distance: '',
        message: []
    })

    const[sato,setEstadoSato] = useState({
        name: 'Sato',
        distance: '',
        message: []
    })

    let satellites = {
      satellites : [kenobi,skywalker,sato]
    };

    let history = useHistory();

    let handleForm = (event, valor) => {

        var randKenobi = Math.floor(Math.random() * 3);
        for(var i = 0; i < randKenobi; i ++) {
            setEstadoKenobi({...kenobi, [kenobi.message]: kenobi.message.unshift(" ")});
        }

        var randSkywalker = Math.floor(Math.random() * 3);
        for(var x = 0; x < randSkywalker; x ++) {
            setEstadoSkywalker({...skywalker, [skywalker.message]: skywalker.message.unshift(" ")});
        }

        var randSato = Math.floor(Math.random() * 3);
        for(var y = 0; y < randSato; y ++) {
            setEstadoSato({...sato, [sato.message]: sato.message.unshift(" ")});
        }

        history.push(
            {
                pathname:"/shipData",
                state:satellites
            }
         );


        event.stopPropagation();
        event.preventDefault();
    }

    let handleKenobi = (event) => {
       if(event.target.name === "message") {
           setEstadoKenobi({...kenobi, [event.target.name]: event.target.value.split(",")});
       }
       else{
           setEstadoKenobi({...kenobi, [event.target.name]: event.target.value});
       }
        event.preventDefault();
    }

    let handleSkywalker = (event) => {
        if(event.target.name === "message") {
            setEstadoSkywalker({...skywalker, [event.target.name]: event.target.value.split(",")});
        }
        else{
            setEstadoSkywalker({...skywalker, [event.target.name]: event.target.value});
        }
        event.preventDefault();
    }

    let handleSato = (event) => {
        if(event.target.name === "message") {
            setEstadoSato({...sato, [event.target.name]: event.target.value.split(",")});
        }
        else {
            setEstadoSato({...sato, [event.target.name]: event.target.value});
        }

        event.preventDefault();
    }

    return (
        <div>
            <form onSubmit={handleForm}>
                <h3>Kenobi:</h3>
                <input type="number" placeholder="Kenobi distance" name="distance" value={kenobi.distance} onChange={(event)=>handleKenobi(event)}/>
                <br/>
                <input type="text" placeholder="Kenobi message" name="message" value={kenobi.message} onChange={(event)=>handleKenobi(event)}/>

                <h3>Skywalker:</h3>
                <input type="number" placeholder="Skywalker distance" name="distance" value={skywalker.distance} onChange={(event)=>handleSkywalker(event)}/>
                <br/>
                <input type="text" placeholder="Skywalker message" name="message" value={skywalker.message} onChange={(event)=>handleSkywalker(event)}/>

                <h3>Sato:</h3>
                <input type="number" placeholder="Sato distance" name="distance" value={sato.distance} onChange={(event)=>handleSato(event)}/>
                <br/>
                <input type="text" placeholder="Sato message" name="message" value={sato.message} onChange={(event)=>handleSato(event)}/>

                <br/>
                <input variant="primary" value="Ship Information" type="submit"/>
            </form>
        </div>
    )

}

export default FindShipInformation;