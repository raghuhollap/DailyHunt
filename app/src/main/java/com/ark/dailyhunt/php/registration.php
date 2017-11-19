<?php
$con=mysqli_connect("localhost","root","","ARK_db");
//if(isset($_POST['submit']))
//{
	$name=$_POST['name'];
	$email=$_POST['email'];
	$password=$_POST['password'];
        $mobile=$_POST['mobile'];
	$sql="insert into REG_USERS(username,password,email,mobile) values('$name','$password','$email','$mobile')";
	if (mysqli_query($con,$sql)) {
      echo "Table have been created successfully";
	  echo "<script>alert('Successfully Registered');</script>";
   } 
	else
	{
	echo "<script>alert('Data not inserted');</script>";
	}
//}
 ?>
<!DOCTYPE html>
<html lang="en">
 <body style="background-color:#2ecc71">
<div class="container-fluid">
  <div class="col-sm-6">
    <div class="row">
      <div class="col-xs-12">
        <form name="insert" action="" method="post">
     <table width="100%"  border="0">
    <tr>
    <th height="62" scope="row">Name </th>
    <td width="71%"><input type="text" name="name" id="name" value=""  class="form-control" required /></td>
  </tr>  
  <tr>
    <th height="62" scope="row">Email id </th>
    <td width="71%"><input type="email" name="email" id="email" value=""  class="form-control" required /></td>
  </tr>
  <tr>
    <th height="62" scope="row">Password </th>
    <td width="71%"><input type="password" name="password" id="password" value=""  class="form-control" required /></td>
  </tr>
<tr>
    <th height="62" scope="row">Mobile Number </th>
    <td width="71%"><input type="text" name="mobile" id="mobile" value=""  class="form-control" required /></td>
  </tr>
 <tr>
    <th height="62" scope="row"></th>
    <td width="71%"><input type="submit" name="submit" value="Submit" class="btn-group-sm" /> </td>
  </tr>
</table>
 </form>
      </div>
    </div>
  </div>
</div>
	</body>
</html>