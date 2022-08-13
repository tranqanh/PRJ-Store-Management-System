

<!doctype html>
<form action="MainController">
<div class='container'>
  <div class='window'>
    <div class='order-info'>
      <div class='order-info-content'>
        <h2>Order Summary</h2>
        <style>
body,html {
  height:100%;
  margin:0;
  font-family:lato;
}

h2 {
  margin-bottom:0px;
  margin-top:25px;
  text-align:center;
  font-weight:200;
  font-size:19px;
  font-size:1.2rem;
  
}
.container {
  height:auto;
  -webkit-box-pack:center;
  -webkit-justify-content:center;
      -ms-flex-pack:center;
          justify-content:center;
  -webkit-box-align:center;
  -webkit-align-items:center;
      -ms-flex-align:center;
          align-items:center;
  display:-webkit-box;
  display:-webkit-flex;
  display:-ms-flexbox;
  display:flex;
  background:-webkit-linear-gradient(#c5e5e5, #ccddf9);
  background:linear-gradient(#c9e5e9,#ccddf9);
}
ul {
  margin:0;
  padding:0;
}
ul li {
  list-style:none;
  padding-left:10px;
  cursor:pointer;
}
ul li:hover {
  background:rgba(255,255,255,0.1);
}

.thin {
  font-weight:400;
}
.small {
  font-size:12px;
  font-size:.8rem;
}
/*.half-input-table {
  border-collapse:collapse;
  width:100%;
}
.half-input-table td:first-of-type {
  border-right:10px solid #4488dd;
  width:50%;
}*/
.window {
  height:auto;
  width:800px;
  background:#fff;
  display:-webkit-box;
  display:-webkit-flex;
  display:-ms-flexbox;
  display:flex;
  box-shadow: 0px 15px 50px 10px rgba(0, 0, 0, 0.2);
  border-radius:30px;
  z-index:10;
  margin: 20px 20px;
  
  
}
.order-info {
  height:auto;
  width:50%;
  padding-left:25px;
  padding-right:25px;
  box-sizing:border-box;
  display:-webkit-box;
  display:-webkit-flex;
  display:-ms-flexbox;
  display:flex;
  -webkit-box-pack:center;
  -webkit-justify-content:center;
      -ms-flex-pack:center;
          justify-content:center;
  position:relative;
  margin-bottom: 15px;
}
.price {
  bottom:0px;
  position:absolute;
  right:0px;
  color:#4488dd;
}
.order-table td:first-of-type {
  width:auto;
}
.order-table {
    position:relative;
}
.line {
  height:1px;
  width:100%;
  margin-top:10px;
  margin-bottom:10px;
  background:#ddd;
}

.line-total {
  height:5px;
  width:100%;
  margin-top:10px;
  margin-bottom:10px;
  background:#ddd;
}

.order-table td:last-of-type {
  vertical-align:top;
  padding-left:25px;
}
.order-info-content {
  table-layout:fixed;
}

.full-width {
  height: 150px;
  width : 150px;
}
.pay-btn {
  border:none;
  background:#22b877;
  line-height:2em;
  border-radius:10px;
  font-size:19px;
  font-size:1.2rem;
  color:#fff;
  cursor:pointer;
  position:absolute;
  bottom:25px;
  width:calc(100% - 50px);
  -webkit-transition:all .2s ease;
          transition:all .2s ease;
}
.pay-btn:hover {
  background:#22a877;
    color:#eee;
  -webkit-transition:all .2s ease;
          transition:all .2s ease;
}

.total {
  margin-top:30px;
  font-size:20px;
  font-size:1.3rem;
  position:absolute;
  bottom:30px;
  right:27px;
  left:35px;
}
.dense {
  line-height:1.2em;
  font-size:16px;
  font-size:1rem;
}
.input-field {
  background:rgba(255,255,255,0.1);
  margin-bottom:10px;
  margin-top:3px;
  line-height:1.5em;
  font-size:20px;
  font-size:1.3rem;
  border:none;
  padding:5px 10px 5px 10px;
  color:#fff;
  box-sizing:border-box;
  width:100%;
  margin-left:auto;
  margin-right:auto;
}
.credit-info {
  background:#4488dd;
  height:auto;
  width:50%;
  color:#eee;
  -webkit-box-pack:center;
  -webkit-justify-content:center;
      -ms-flex-pack:center;
          justify-content:center;
  font-size:14px;
  font-size:.9rem;
  display:-webkit-box;
  display:-webkit-flex;
  display:-ms-flexbox;
  display:flex;
  box-sizing:border-box;
  padding-left:25px;
  padding-right:25px;
  border-top-right-radius:30px;
  border-bottom-right-radius:30px;
  position:relative;
}

.credit-card-image {
  display:block;
  max-height:80px;
  margin-left:auto;
  margin-right:auto;
  margin-top:35px;
  margin-bottom:15px;
}
.credit-info-content {
  margin-top:25px;
  -webkit-flex-flow:column;
      -ms-flex-flow:column;
          flex-flow:column;
  display:-webkit-box;
  display:-webkit-flex;
  display:-ms-flexbox;
  display:flex;
  width:100%;
}
@media (max-width: 600px) {
  .window {
    width: 100%;
    height: 100%;
    display:block;
    border-radius:0px;
  }
  .order-info {
    width:100%;
    height:auto;
    padding-bottom:100px;
    border-radius:0px;
  }
  .credit-info {
    width:100%;
    height:auto;
    padding-bottom:100px;
    border-radius:0px;
  }
  .pay-btn {
    border-radius:0px;
  }
}
       
 </style>
        
        
         <img src='https://khacdauankhanh.com.vn/wp-content/uploads/2019/09/khac-dau-icon-1-02.png' height='1200' width='250' class='credit-card-image' id='credit-card-image'></img>   
               
        <div class='total'>
          <span style='float:left;'>
<a href="MainController?action=add_more" > Add More </a>
          </span>
          <span style='float:right; text-align:right;'>
          </span>
        </div>
</div>
</div>
        <div class='credit-info'>
          <div class='credit-info-content'>
            <table class='half-input-table'>
              <tr><td>Please select your card: </td><td><div class='dropdown' id='card-dropdown'><div class='dropdown-btn' id='current-card'>Visa</div>
                <div class='dropdown-select'>
                <ul>
                  <li>Master Card</li>
                  <li>American Express</li>
                  </ul></div>
                </div>
               </td></tr>
            </table>
            <img src='https://i.pinimg.com/736x/15/4d/77/154d77992b2da5ef5a35d404cae068be.jpg' height='120' class='credit-card-image' id='credit-card-image'></img>
            FullName
            <input class='input-field'></input>
            Address
            <input class='input-field'></input>
            <table class='half-input-table'>
              <tr>
                <td> Phone
                  <input class='input-field'></input>
                </td>
                <td>Card Number
                  <input class='input-field'></input>
                </td>
              </tr>
            </table>
            <button class='pay-btn' href="MainController?action=confirm&totalall=${total}">Checkout</button>

          </div>

        </div>
    
      </div>
    </div>
            </form>
