<?php
	include_once("database.php");
	
	$deposit= $_REQUEST['username'];

  	$sqlString = "SELECT deposit, id FROM user WHERE username = '$deposit'";
	$rs = mysql_query($sqlString);

	if($rs) {
   		while($objRs = mysql_fetch_assoc($rs)) {
      		$output[] = $objRs;
   		}
   	echo json_encode($output);
	}
	mysql_close();
?>