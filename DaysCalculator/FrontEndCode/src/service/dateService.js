import axios from "axios";

const DATE_URL = "http://localhost:8080/DaysCalculator";

class dateService{

    // getDate(){
    //     return axios.post(DATE_URL)
    //                 .then(res=>{
    //                     console.log(res.data)    
    //                 })
    //                 .catch(err=>{
    //                     console.log(err)
    //                 })
    // }

    getResult(){
     return axios.post(DATE_URL);
    }
}

export default new dateService();