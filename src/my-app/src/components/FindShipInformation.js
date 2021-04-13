import React, {useState} from 'react';

function FindShipInformation() {

    const[kenobi,setEstadoKenobi] = useState({
        name:'Kenobi',
        distance: '',
        message: ''
    })

    const[skywalker,setEstadoSkywalker] = useState({
        name: 'Skywalker',
        distance: '',
        message: ''
    })

    const[sato,setEstadoSato] = useState({
        name: 'Sato',
        distance: '',
        message: ''
    })

    let satellites = {
      satellites : [kenobi,skywalker,sato]
    };

    let handleForm = (event, valor) => {

        console.log(satellites);

        event.stopPropagation();
        event.preventDefault();
    }

    let handleKenobi = (event) => {
        setEstadoKenobi({...kenobi, [event.target.name]: event.target.value});
        event.preventDefault();
    }

    let handleSkywalker = (event) => {
        setEstadoSkywalker({...skywalker, [event.target.name]: event.target.value});
        event.preventDefault();
    }

    let handleSato = (event) => {
        setEstadoSato({...sato, [event.target.name]: event.target.value});
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
                <input variant="primary" value="Login" type="submit"/>
            </form>
        </div>
    )

}

export default FindShipInformation;