import React, { Component } from 'react'
// import dateService from './service/dateService';
import axios from 'axios';
export default class HomeComponent extends Component {
    constructor(props){
        super(props)
        
        this.state = {
            value : false,
            date:'',
            duration:'',
            direction:'',
            result : ''
        }
        this.changeDate = this.changeDate.bind(this);
        this.changeDuration = this.changeDuration.bind(this);
        this.changeDirection = this.changeDirection.bind(this);
        this.getDate = this.getDate.bind(this);
    }
    
    changeDate = (event) => {
        this.setState({
            date: event.target.value
        });
    }

    changeDuration = (event) => {
        this.setState({
            duration: event.target.value
        });
    }
     
    changeDirection = (event) => {
        this.setState({
            direction: event.target.value
        });
    }


    getDate = (event) => {
        event.preventDefault();
        let getResult = {
            startDate : this.state.date,
            daysDuration : this.state.duration,
            direction : this.state.direction,
        };
        console.log(getResult);
        axios.post("http://localhost:8080/DaysCalculator",getResult)
                    .then(res=>{
                        this.setState({result:res.data});
                        this.setState({value:true});
                    })
                    .catch(err=>{
                        console.log(err)
                    })
    }

    render() {
        return (
            <div className='main'>
                <div className='row'>
                    <div className="card col-md-6 offset-md-3 offset-md-3">
                        <h2 className="text-center">Date Calculator</h2>
                        <div className="card-body">
                            <form>
                                <div className="form-group">
                                    <label className='sd'>Select Date : </label>
                                    <input className='sd' type="date" value={this.state.date} onChange={this.changeDate} />
                                </div>
                                <div className="form-group">
                                    <label className='ed'>Enter Duration : </label>
                                    <input className='ed' type="text" value={this.state.duration} onChange={this.changeDuration} />
                                </div>
                                <div className="form-group">
                                    <label className='edd'>Enter Direction : </label>
                                    <select id={this.state.direction} onChange={this.changeDirection} >
                                        <option id="1" value="1">
                                        Forward
                                        </option>
                                        <option id="0" value="0">
                                        Backward
                                        </option>
                                    </select>
                                </div>
                                <br /><br />
                                <button className='btn btn-success' onClick={this.getDate}>Get Date</button>
                            </form>
                        </div>
                        <div className='result'>
                            {
                                this.state.value && <h2 className='result'>Result Date : {this.state.result.resultDate +"/"+this.state.result.resultMonth +"/"+ this.state.result.resultYear}</h2>
                            }
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}
