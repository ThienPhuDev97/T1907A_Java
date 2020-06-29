<!DOCTYPE html>
<?php
require_once 'xuli.php';
?>
<html>
<head>
  <title></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>

  <div class="container">
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top navi" style="position: fixed; background-color: white !important;">
    <div class="container">
        <a class="navbar-brand"  style="color: black  ; font-weight: bold" href="Home.html">Thien Phu Mobile</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" style="color: black ; font-weight: bold" href="Home.html">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: black ; font-weight: bold" href="">About Us</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: black  ; font-weight: bold" href="">Contact Us</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: black  ; font-weight: bold" href="">Services</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: black  ; font-weight: bold" href="">News & Event</a>
                </li>
            </ul>
        </div>
        <div class="book-ticket col-xs-12 col-sm-12 col-md-12 col-lg-2">
            <a href="#">
                <i class="fas fa-shopping-cart"></i>Login
            </a>
        </div>
    </div>
</nav>

    <div id="header" style="width: 100%">
      <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="img/img1.png.jfif" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="img/img1.png.jfif" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="img/img3.jfif" class="d-block w-100" alt="...">
          </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>

    </div>
    <?php

echo '<div class="row "style="height: 100px, margin:0;margin: 0px; margin-top: 20px;">';
for ($i = 0; $i < 3; $i++) {
	echo '
      <div class="col-sm-6 col-md-4  align-self-sm-center">
      <div class="card">
      <img src=' . $productList[$i]['linkimg'] . ' class="card-img-top editing" alt="...">
      <div class="card-body">
      <a href="" class="card-title">' . $productList[$i]['tieude'] . '</a>
      <p class="card-text">' . $productList[$i]['tragop'] . '</p>
      <p id="price">' . $productList[$i]['price'] . '</p>
      <p id="PhoneID" style="display: none;">' . $productList[$i]['id'] . '</p>
      <button id="addtocard" class="btn btn-primary" onclick="addID(' . $productList[$i]['id'] . ')">Chi tiet </button>
      </div>
      </div>
      </div>
      ';
}
echo '</div>';

echo '<div class="row "style="height: 100px, margin:0;margin: 0px; margin-top: 20px;">';
for ($i = 3; $i < 6; $i++) {
	echo '
      <div class="col-sm-6 col-md-4  align-self-sm-center">
      <div class="card">
      <img src=' . $productList[$i]['linkimg'] . ' class="card-img-top editing" alt="...">
      <div class="card-body">
      <a href="" class="card-title">' . $productList[$i]['tieude'] . '</a>
      <p class="card-text">' . $productList[$i]['tragop'] . '</p>
      <p id="price">' . $productList[$i]['price'] . '</p>
      <p id="PhoneID" style="display: none;">' . $productList[$i]['id'] . '</p>
      <button id="addtocard" class="btn btn-primary" onclick="addID(' . $productList[$i]['id'] . ')">Chi tiet</button>
      </div>
      </div>
      </div>
      ';
}
echo '</div>';

//echo '<button  class="btn btn-primary" onclick="showArray()">Thanh Toan</button>';

?>

<script type="text/javascript">

  function addID(id){
    var link = "detailProduct.php?id='"+id+"'";
    window.open(link);
  }
</script>


    </div>
  </div>
</body>
</html>