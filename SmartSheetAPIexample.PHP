<html>
Hello this is my test of the Smartsheet API. It can be hosted with apache.
<br>
 <?php

$baseURL = "https://api.smartsheet.com/1.1";
$me = $baseURL. "/user/me";
$sheetsURL = $baseURL. "/sheets/";
$HeaderToken = "Authorization: Bearer INSERT TOKEN HERE";
// Connect to Smartsheet API to get Sheet List
$opts = array(
  'http'=>array(
    'method'=>"GET",
    'header'=> $HeaderToken
  )
);
echo $opts[0];
$context = stream_context_create($opts);
$fp = fopen($sheetsURL, 'r', false, $context);
fpassthru($fp);
fclose($fp);
$Data = json_decode($fp);
echo $Data;

?>

</html>
