<?php

function getAge($date){
    $today = new DateTime();
    $birthdate = new DateTime($date);
    $interval = $today->diff($birthdate);
    return $interval->format('%y');
}

?>

