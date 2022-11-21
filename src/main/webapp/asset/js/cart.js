// increase and decrease item
function amountItem(){
    var increment = document.getElementsByClassName("plus");
    var decrement = document.getElementsByClassName("minus");
    for (var i = 0; i < increment.length; i++) {
        var plus = increment[i];
        plus.addEventListener("click", function (event) {
            var buttonClicked = event.target;
            var input = buttonClicked.parentElement.children[1];
            var inputValue = input.innerHTML;
            var newValue = parseInt(inputValue) + 1;
            newValue = newValue < 10 ? "0" + newValue : newValue;
            input.innerHTML = newValue;
            totalCart();
        });
    }
    for (var i = 0; i < decrement.length; i++) {
        var minus = decrement[i];
        minus.addEventListener("click", function (event) {
            var buttonClicked = event.target;
            var input = buttonClicked.parentElement.children[1];
            var inputValue = input.innerHTML;
            var newValue = parseInt(inputValue) - 1;
            if (inputValue > 1) {
                newValue = newValue < 10 ? "0" + newValue : newValue;
                input.innerHTML = newValue;
                totalCart();
            } else {
                alert("Số lượng tối thiểu là 1!");
            }
        });
    }
}
// remove item
function removeItem(){
    var remove_item = document.getElementsByClassName("remove_item");
    console.log(remove_item)
    for (var i = 0; i < remove_item.length; i++) {
        var item = remove_item[i];
        item.addEventListener("click", function (event) {
            var itemClicked = event.target;
            var item = itemClicked.parentElement.parentElement;
            item.remove();
            totalCart();
        });
    }
}
var input_password = document.getElementsByClassName("input password");
function show_password() {
    var input_password = document.getElementsByClassName("input password");
    for (var i = 0; i < input_password.length; i++) {
        var x = input_password[i];
        if (x.type === "password") {
            x.type = "text";
        } else {
            x.type = "password";
        }
    }
}

// format money
function formatCash(str) {
    return str
        .split("")
        .reverse()
        .reduce((prev, next, index) => {
            return (index % 3 ? next : next + ".") + prev;
        });
}

function totalCart() {
    var last_price = 0;
    var first_price = 0;
    var items = document.getElementsByClassName("items-price");
    for (var i = 0; i < items.length; i++) {
        var end_price = items[i].querySelector(".end-price span").innerHTML;
        var price = items[i].querySelector(".price span").innerHTML;
        var amount =
            items[i].parentElement.children[2].querySelector(
                ".wrapper .num"
            ).innerHTML;

        var test = price * 10;

        var priceA = parseFloat(price) * 1000000 * amount;
        var priceB = parseFloat(end_price) * 1000000 * amount;

        first_price += priceA;
        last_price += priceB;
    }
    document.querySelector(".temp-price span").innerHTML = formatCash(
        first_price + ""
    );
    document.querySelector(".promo-price span").innerHTML =
        "-" + formatCash(-last_price + first_price + "");
    document.querySelector(".last-price span").innerHTML = formatCash(
        last_price + ""
    );
}
// add cart
var btn = document.querySelectorAll(".check_add");
btn.forEach(function (button, index) {
    button.addEventListener("click", function (event) {
        {
            addCart();
        }
    });
});
function addCart() {
    var addDiv = document.createElement("div");
    addDiv.className = "items";
    var divContent =
        '<div class="pic float-left"><img id="items-pic" src="../../asset/img/ip13-pro-max.jpeg" alt="Sản phẩm" /></div><div class="float-left"><div class="items-type float-left"><h3 class="items-name">iPhone 13 128GB</h3><div class="colors"><span>Màu</span><ul class="ordercolorful"></ul></div></div><div class="items-price float-left"><p class="end-price"><span>19.190.000</span> <sup>đ</sup></p><p class="price"><span>24.990.000</span> <sup>đ</sup></p><p class="discount inline-block">Giảm -30 %</p></div><div class="items-amount float-left"><div class="wrapper"><span class="minus">-</span><span class="num inline-block">01</span><span class="plus">+</span></div></div></div><div class="remove_item float-right"><i class="close-icon ti-close"></i><div class="clear"></div></div>';
    addDiv.innerHTML = divContent;
    var cartItem = document.querySelector(".container .list-items");
    cartItem.append(addDiv);
    removeItem(); // chú ý chỗ này !!!!
    amountItem();
    totalCart();
}
/// phần form người dùng
function formvalidate(){
    var resutl = true;
    var name = document.getElementById("name").value;
    var phone = document.getElementById("phone").value;
    var email = document.getElementById("email").value;
    var address = document.getElementById("address").value;

    if(name.length == 0){
        document.getElementById("name_empty").innerHTML = "Vui lòng nhập tên";
        document.getElementById("name_empty").style.display = "block";
        resutl = false;
    }
    else {
        document.getElementById("name_empty").style.display = "none";
    }

    if(phone.length == 0){
        document.getElementById("phone_empty").style.display = "block";
        document.getElementById("phone_empty").innerHTML = "Vui lòng nhập số điện thoại";
        resutl = false;
    }
    else{
        if(!validatePhone(phone)) {
            document.getElementById("phone_empty").style.display = "block";
            document.getElementById("phone_empty").innerHTML = "Vui lòng nhập đúng định dạng số điện thoại bắt đầu với 84 hoặc 0 theo sao là 9 số";
            resutl = false;
        }
        else{
            document.getElementById("phone_empty").style.display = "none";
        }
    }
    if(email.length != 0)
    {
        if(!isEmail(email)){
            document.getElementById("email_empty").style.display = "block";
            document.getElementById("email_empty").innerHTML = "Vui lòng nhập đúng định dạng email";
            resutl = false;
        }
        else {
            document.getElementById("email_empty").style.display = "none";
        }
    }
    else {
        document.getElementById("email_empty").style.display = "none";
    }
    if(address.length == 0){
        document.getElementById("address_empty").style.display = "block";
        document.getElementById("address_empty").innerHTML = "Vui lòng nhập địa chỉ nhận hàng";
        resutl = false;
    }
    else {
        document.getElementById("address_empty").style.display = "none";
    }
    if(resutl == true)
    {
        callServlet('POST');
    }
}
function validatePhone(number) {
    return /(84|0)+([3|5|7|8|9])+([0-9]{8})\b/.test(number);
}
function callServlet(methodType){
    document.getElementById("form-order").action="orderControl";
    document.getElementById("form-order").method=methodType;
    document.getElementById("form-order").submit();
}
function isEmail(email) {
    return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
}
function checkName(){
    var name = document.getElementById("name").value;
    if(name.length == 0){
        document.getElementById("name_empty").style.display = "block";
        document.getElementById("name_empty").innerHTML="Vui lòng nhập tên"
    }
    else {
        document.getElementById("name_empty").style.display = "none";
    }
}
function checkEmail(){
    var email = document.getElementById("email").value;
    if(email.length != 0)
    {
        if(!isEmail(email)){
            document.getElementById("email_empty").style.display = "block";
            document.getElementById("email_empty").innerHTML = "Vui lòng nhập đúng định dạng email";

        }
        else {
            document.getElementById("email_empty").style.display = "none";
        }
    }
    else {
        document.getElementById("email_empty").style.display = "none";
    }
}
function checkAddress(){
    var address = document.getElementById("address").value;
    if(address.length == 0){
        document.getElementById("address_empty").style.display = "block";
        document.getElementById("address_empty").innerHTML = "Vui lòng nhập địa chỉ nhận hàng";
    }
    else {
        document.getElementById("address_empty").style.display = "none";
    }

}
function checkPhone() {
    var phone = document.getElementById("phone").value;
    if (phone.length == 0) {
        document.getElementById("phone_empty").style.display = "block";
        document.getElementById("phone_empty").innerHTML = "Vui lòng nhập số điện thoại";
    } else {
        if (!validatePhone(phone)) {
            document.getElementById("phone_empty").style.display = "block";
            document.getElementById("phone_empty").innerHTML = "Vui lòng nhập đúng định dạng số điện thoại bắt đầu với 84 hoặc 0 theo sao là 9 số";
        } else {
            document.getElementById("phone_empty").style.display = "none";
        }
    }
}

