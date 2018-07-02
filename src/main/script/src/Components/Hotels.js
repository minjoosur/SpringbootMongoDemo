import React, { Component } from 'react';
import HotelItem from './HotelItem'

class Hotels extends Component {

  render() {
  		let hotelItems;
	if(this.props.hotels){
		hotelItems = this.props.hotels.map(hotel => {
			return (
				<HotelItem key={hotel.name} hotel={hotel} />
				);
		});
	}
    return (  //you can have only one 'div' at the top level!!!
      <div className="Hotels">
      {hotelItems}
      </div>
    );
  }
}

export default Hotels;
