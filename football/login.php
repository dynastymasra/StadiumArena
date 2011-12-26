<?php
    include_once("database.php");
	
    $username = $_REQUEST['username'];
    $password = $_REQUEST['password']; 
    
    $query = "select * from user where username ='$username' and password = '$password'";
    $execute = mysql_query($query);
    $jumlah = mysql_num_rows($execute);
    
    if ($jumlah >= 1 ) {
        echo "TRUE";
    }
	else {
        echo "FALSE";
    }
?>
