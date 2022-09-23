import React, { Component } from 'react'
import { Link } from "react-router-dom";

export default class IndexComponent extends Component {
  render() {
    return (
      <div>
        <table>
            <tr>
                <td><h2>Calculate Days</h2><br />
                <h4>Example : Enter the Duration of the Days you get the Date it could be any Direction</h4></td>
                <td  className='link'><Link to="/Home">Go</Link></td>
            </tr><br /><br />
            <tr>
              <td><h2>Date Calculator</h2> <br />
              <h4>Example : This one is calcating the Days between the two dates it will show the Days, Weaks, Months and Years between the Dates</h4></td>
              <td className='link'><Link to="/DaysCalculate">Go</Link></td>
            </tr>
        </table>
      </div>
    )
  }
}
