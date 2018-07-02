import React, { Component } from 'react';

class AddHotel extends Component {
//if you dont' have a constructor, you can never see an object with json format
  constructor(){
    super();
    this.state = {
      newHotel:{}
    }
  }

  static defaultProps = {
    pricesPerNight: ['100', '200', '300']
  }

  handleSubmit(e){
    if(this.refs.name.value === ''){
      alert('Name is required');
    } else {
      this.setState({newHotel:{
        name: this.refs.name.value,
        pricePerNight: this.refs.pricePerNight.value
      }}, function(){
        console.log(this.state)
        this.props.addHotel(this.state.newHotel);
      })
    }
    e.preventDefault();
  }

  render() {
    let pricePerNightOptions = this.props.pricesPerNight.map(pricePerNight => {
      return <option key={pricePerNight} value={pricePerNight}>{pricePerNight}</option>
    })
    return (  //you can have only one 'div' at the top level!!!
      <div>
      <h3>Add Hotel </h3>
      <form onSubmit={this.handleSubmit.bind(this)}>
      <div>
      <label>Name</label><br />
      <input type="text" ref="name" />
      </div>
      <div>
      <label>Price Per Night</label><br />
      <select ref="pricePerNight">
      {pricePerNightOptions}
      </select>
      </div>
      <input type="submit" value="Submit" />
      </form>
      </div>
    );
  }
}

export default AddHotel;
