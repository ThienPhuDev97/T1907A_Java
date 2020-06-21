<!DOCTYPE html>

<!-- <?php  require_once('Dangki.php');?> -->
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		
		<form action="" method="POST">

			

     <div class="form-group">
       <label for="UserName">UserName</label>
       <input type="text" class="form-control" name="UserName" id="UserName">
     </div>

     <div class="form-group">
       <label for="fullname">FullName</label>
       <input type="text" class="form-control" name="fullname" id="fullname">
     </div>
     <div class="form-group">
      <label for="email">Email</label>
      <input type="email" class="form-control" name="email" id="email">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" name="Password" id="Password">
    </div>
    
    <div class="form-group">
      <label for="phone">Phone:</label>
      <input type="password" class="form-control" name="phone" id="phone">
    </div>


    <button  type="button" id="insertData" class="btn btn-default">Register</button>
  </form>
  <p id="showdata"></p>
</div>

<script type="text/javascript">
  $('#insertData').on('click',function(){
    var UserName = $('#UserName').val();
    var fullname = $('#fullname').val();
    var email = $('#email').val();
    var Password = $('#Password').val();
    var phone = $('#phone').val();

    if(UserName==''|| fullname==''|| email==''|| Password==''|| phone ==''){
      alert('nhap day du thong tin')
    }else{
      $.post('Dangki.php',
      {
        UserName:UserName,
        fullname:fullname,
        email:email,
        Password:Password,
        phone:phone
      },function(data){
        alert(data)
        window.location.href = 'login.php';
      })
    }

  })
  
</script>

</body>
</html>