import React, { Component } from 'react';

class HotelItem extends Component {
  render() {
    return (  //you can have only one 'div' at the top level!!!
      <li className="Hotel">
      <strong> {this.props.hotel.name}</strong>: {this.props.hotel.pricePerNight}
      </li>
    );
  }
}

export default HotelItem;
