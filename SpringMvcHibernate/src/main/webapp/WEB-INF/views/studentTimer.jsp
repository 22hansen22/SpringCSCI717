<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value='/static/css/css1.css' />" rel="stylesheet"></link>
<%@ include file="/WEB-INF/fragments/header1.jspf" %>

</head>
<body>
Hi hola

<div class="container">
            <h1>TimeCircle examples</h1>
            <h2>Time until 2014</h2>
            <div id="DateCountdown" data-date="2014-01-01 00:00:00" style="width: 500px; height: 125px; padding: 0px; box-sizing: border-box; background-color: #E0E8EF"></div>
            <div style="padding: 10px;">
                <input type="date" id="date" value="2014-01-01">
                <input type="time" id="time" value="00:00">
            </div>
            <hr>
            <h2>Counting down 1 minute (60 seconds)</h2>
            <div id="CountDownTimer" data-timer="2" style="width: 1000px; height: 250px;"></div>
            <button class="btn btn-success startTimer">Start Timer</button>
            <button class="btn btn-danger stopTimer">Stop Timer</button>
            <button class="btn btn-info resetTimer">Reset Timer</button>
            <hr>
            <h2>Time since page was opened</h2>
            <div>
                <div style="float: left; width: 100px;">
                    <br>
                    <button class="btn btn-success btn-block fadeIn">Fade in</button><br>
                    <button class="btn btn-danger btn-block fadeOut">Fade out</button>
                </div>
                <div id="PageOpenTimer" style="width: 500px; height: 125px; float: left"></div>
            </div>
        </div>
        <script>
            $("#DateCountdown").TimeCircles();
            $("#CountDownTimer").TimeCircles({ time: { Days: { show: false }, Hours: { show: false } }});
            $("#PageOpenTimer").TimeCircles();
            
            var updateTime = function(){
                var date = $("#date").val();
                var time = $("#time").val();
                var datetime = date + ' ' + time + ':00';
                $("#DateCountdown").data('date', datetime).TimeCircles().start();
            }
            $("#date").change(updateTime).keyup(updateTime);
            $("#time").change(updateTime).keyup(updateTime);
            
            // Start and stop are methods applied on the public TimeCircles instance
            $(".startTimer").click(function() {
                $("#CountDownTimer").TimeCircles().start();
            });
            $(".stopTimer").click(function() {
                $("#CountDownTimer").TimeCircles().stop();
            });
            $(".resetTimer").click(function() {
            	
                $("#CountDownTimer").TimeCircles().restart();
                $("#CountDownTimer").TimeCircles().stop();
            });

            // Fade in and fade out are examples of how chaining can be done with TimeCircles
            $(".fadeIn").click(function() {
                $("#PageOpenTimer").fadeIn();
            });
            $(".fadeOut").click(function() {
                $("#PageOpenTimer").fadeOut();
            });

        </script>       
        
</body>
</html>