import React, { Component } from 'react'
import axios from 'axios';

export default class extends Component {
    constructor(props){
        super(props)

        this.state = {
            strDate :  '',
            endDate : '',
            value : false
        }
        this.changeStrDate = this.changeStrDate.bind(this);
        this.changeEndDate = this.changeEndDate.bind(this);
    }
    changeStrDate = (date) =>{
        this.setState({strDate : date.target.value});
    }
    changeEndDate = (date) => {
        this.setState({endDate : date.target.value});
    }

    getResult = (event) =>{
        event.preventDefault();

        let getResult = {
            startDate : this.state.strDate,
            endDate : this.state.endDate
        };
        console.log(getResult);
        axios.post("http://localhost:8080/DateCalculate",getResult)
                    .then(res=>{
                        this.setState({result:res.data});
                        this.setState({value:true});
                        console.log(res.data);
                    })
                    .catch(err=>{
                        console.log(err)
                    })
    }
  render() {
    return (
      <div>
        <h2 className='dc'>Days Calculator</h2>
            <label className='strd'>Starting Date :  </label>
            <input className='strd' type="date" value={this.state.strdate} onChange={this.changeStrDate} /><br />
            <label className='endd'>End Date :  </label>
            <input className='endd' type="date" value={this.state.enddate} onChange={this.changeEndDate} />
        <button className='t2' onClick={this.getResult}>Get Result</button>      

        <div className="result">
            {
                this.state.value &&  <h2 className='result2'> Result : "{this.state.result.yearCount}" <label>Years ,</label> "{this.state.result.monthCount}" <label>Months,</label> "{this.state.result.weakCount}" <label>Weaks ,</label> "{this.state.result.daysCount}" <label>Days.</label> </h2>
            }
        </div>
      </div>
    )
  }
}
