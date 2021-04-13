import FindShipInformation from './components/FindShipInformation';
import ShipData from './components/ShipData';
import React, {useState} from 'react';
import {BrowserRouter} from 'react-router-dom';
import {Route} from 'react-router-dom';
import './App.css';

function App() {

  const[estado,setEstado] = useState({
    opcionesMenu:[{name:'FindShipInformation',path:"/"},{name:'ShipData',path:"/shipData"}],
  })

  return (
      <BrowserRouter>
         <Route exact path='/' component={()=><FindShipInformation />}/>
         <Route exact path='/shipData' render={(props)=><ShipData {...props} state={props}/>}/>
      </BrowserRouter>
  );
}

export default App;
