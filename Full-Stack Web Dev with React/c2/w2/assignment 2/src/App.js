import React, { Component } from 'react';
import Main from './components/MainComponent';
import './App.css';
import {BrowserRouter} from 'react-router-dom';

//This is the code provided by lecturer, with provided react version
class App extends Component {

  render() {
    return (
      <BrowserRouter>
        <div className="App">
          <Main />
        </div>
      </BrowserRouter>
    );
  }
}

export default App;



/////////////////////////////////////////////////////////////
//This is template provided by latest version
// function App() {
//   return (
//     <div className="App">
//       <Navbar dark color='primary'>
//         <div className='container'>
//           <NavbarBrand href="/">Ristorante Con Fusion</NavbarBrand>
//         </div>
//       </Navbar>
//     </div>
//   );
// }
// export default App;



