import React, { Component } from 'react';
import './App.css';
import Hotels from './Components/Hotels';
import AddHotel from './Components/AddHotel';
import ReactDOM from 'react-dom';
import axios from 'axios';

class App extends Component {
	//constructor
	constructor(){
		super();
		this.state = {
			hotels: []
		}
	}

		componentDidMount(){
			axios.get("http://localhost:8080/hotels/all")
				.then(res => {
					this.setState({hotels:res.data});
				});
		}

	handleAddHotel(hotel){
		let hotels = this.state.hotels;
		hotels.push(hotel);
		console.log(hotel);
		axios.put("http://localhost:8080/hotels",{hotel})
		this.setState({hotels:hotels});
	}

  render() {
  	console.log(this.props);
    return (  //you can have only one 'div' at the top level!!!
      <div className="App">
      <AddHotel addHotel={this.handleAddHotel.bind(this)}/>
      <Hotels hotels={this.state.hotels} />
      </div>
    );
  }
}

export default App;
