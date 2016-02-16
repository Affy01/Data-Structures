<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Maps Application</title>
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
        <meta charset="utf-8">
        <style>
            html, body {
                height: 100%;
                margin: 0;
                padding: 0;
            }
            #map {
                height: 100%;
                float: left;
                width: 77%;
            }
            #tab{
                border-radius: 10px;
                background-color: grey;
                height: 100%;
                float: left;
                width: 23%;
                /*position:absolute;*/
            }
            .button{
                padding: 5px 5px 5px 5px;
                margin-left: 10px;
                margin-top: 15px;
                border-radius: 10px;
                width:181px;
            }
            #latLng{
                margin-left:20px;
                margin-top: 30px;
            }
            #xy{
                position:absolute;
                /*background-color: yellow;*/
                float:left;
                height:100px;
                width:100%;
                margin-top: 10px;
            }
            #rectanglediv{
                position:absolute;
                /*background-color: yellow;*/
                float:left;
                height:100px;
                width:100%;
                margin-top: 75px;
                margin-left:20px;
            }
            #table{
                position: absolute;
                /*background-color: green;*/
                float:left;
                height:37%;
                width: 100%;
                margin-top: 195px;
                margin-left: 3px;
            }
        </style>

    </head>
    <body>
        <div id = "map"></div>
        <div id = "tab">
            <p onclick ="displayHelp()"style = "margin-left:80%" onmouseover= "this.style.cursor = 'pointer';
                    this.style.color = 'blue';" onmouseout = "this.style.color = 'black';">Help</p>
            <form name="form3" action="MyFirstServlet">
                <input type="hidden" name="field1" value=" ">
                <input type="hidden" name="field2" value=" ">
                <input type="hidden" name="field3" value=" ">
                <input type="hidden" name="field4" value=" ">
                <input type="hidden" name="field5" value=" ">
                <input type="hidden" name="field6" value=" ">
                <input type="hidden" name="flag3" value=" ">
                <button class = "button" style="margin-left:50px">GET CLOSEST POINTS</button></br>
                <button class = "button" style="margin-left:50px">GET COUNT</button></br>
                <SCRIPT LANGUAGE="JAVASCRIPT">
                    document.getElementById('testarrayx').value = testarrayx;
                    document.getElementById('count').value = count;
                </SCRIPT>
            </form>
            <div id = "xy">
                <p id = "latLng"></p>
                <p hidden id ="returnedx">${testarrayx[11][2]}</p>
                <p hidden id ="returnedy">${testarrayx[11][3]}</p>
            </div>
            <div id = "rectanglediv">
                <p id = "rectangledisplay"></p>
                <p hidden="returnedx1">${count[1]}</p>
                <p hidden="returnedy1">${count[2]}</p>
                <p hidden="returnedx2">${count[3]}</p>
                <p hidden="returnedy2">${count[4]}</p>
                <table id = 'rectangleTable'>
                    <tr>
                        <td>${count[0]}</td>
                    </tr>
                </table>
            </div>
            <div id = "table">
                <table id = "pointsTable">
                    <tr>
                        <td>${testarrayx[0][0]}</td>
                        <td>${testarrayx[0][1]}</td>
                        <td>${testarrayx[0][2]}</td>
                        <td>${testarrayx[0][3]}</td>
                    </tr>
                    <tr>
                        <td>${testarrayx[1][0]}</td>
                        <td>${testarrayx[1][1]}</td>
                        <td id = "pointx1">${testarrayx[1][2]}</td>
                        <td id = "pointy1">${testarrayx[1][3]}</td>
                    </tr>
                    <tr>
                        <td>${testarrayx[2][0]}</td>
                        <td>${testarrayx[2][1]}</td>
                        <td id = "pointx2">${testarrayx[2][2]}</td>
                        <td id = "pointy2">${testarrayx[2][3]}</td>
                    </tr>
                    <tr>
                        <td>${testarrayx[3][0]}</td>
                        <td>${testarrayx[3][1]}</td>
                        <td id = "pointx3">${testarrayx[3][2]}</td>
                        <td id = "pointy3">${testarrayx[3][3]}</td>
                    </tr>
                    <tr>
                        <td>${testarrayx[4][0]}</td>
                        <td>${testarrayx[4][1]}</td>
                        <td id = "pointx4">${testarrayx[4][2]}</td>
                        <td id = "pointy4">${testarrayx[4][3]}</td>
                    </tr>
                    <tr>
                        <td>${testarrayx[5][0]}</td>
                        <td>${testarrayx[5][1]}</td>
                        <td id = "pointx5">${testarrayx[5][2]}</td>
                        <td id = "pointy5">${testarrayx[5][3]}</td>
                    </tr>
                    <tr>
                        <td>${testarrayx[6][0]}</td>
                        <td>${testarrayx[6][1]}</td>
                        <td id = "pointx6">${testarrayx[6][2]}</td>
                        <td id = "pointy6">${testarrayx[6][3]}</td>
                    </tr>
                    <tr>
                        <td>${testarrayx[7][0]}</td>
                        <td>${testarrayx[7][1]}</td>
                        <td id = "pointx7">${testarrayx[7][2]}</td>
                        <td id = "pointy7">${testarrayx[7][3]}</td>
                    </tr>
                    <tr>
                        <td>${testarrayx[8][0]}</td>
                        <td>${testarrayx[8][1]}</td>
                        <td id = "pointx8">${testarrayx[8][2]}</td>
                        <td id = "pointy8">${testarrayx[8][3]}</td>
                    </tr>
                    <tr>
                        <td>${testarrayx[9][0]}</td>
                        <td>${testarrayx[9][1]}</td>
                        <td id = "pointx9">${testarrayx[9][2]}</td>
                        <td id = "pointy9">${testarrayx[9][3]}</td>
                    </tr>
                    <tr>
                        <td>${testarrayx[10][0]}</td>
                        <td>${testarrayx[10][1]}</td>
                        <td id = "pointx10">${testarrayx[10][2]}</td>
                        <td id = "pointy10">${testarrayx[10][3]}</td>
                    </tr>
                </table>
            </div>
        </div>


        <script>
            var rectangle;
            var map;
//            var infoWindow;
            var myLatLng;
            var latitude;
            var longitude;
            var north1;
            var south1;
            var east1;
            var west1;
            function initMap() {
                document.form3.flag3.value = 1;
                var myCenter = {lat: 39, lng: -97};

                map = new google.maps.Map(document.getElementById('map'), {
                    zoom: 5,
                    center: myCenter
                });

                var marker = new google.maps.Marker();

                map.addListener('click', function (event) {
                    myLatLng = {lat: event.latLng.lat(), lng: event.latLng.lng()};
                    document.form3.field1.value = event.latLng.lat();
                    document.form3.field2.value = event.latLng.lng();
                    document.form3.flag3.value = 2;
                    marker.setVisible(false);
                    document.getElementById('pointsTable').innerHTML = "";
                    marker = new google.maps.Marker({
                        position: myLatLng,
                        map: map
                                // icon : 'http://maps.google.com/mapfiles/ms/icons/purple-dot.png'
                    });
                    document.getElementById('latLng').innerHTML = 'LATTITUDE: ' + event.latLng.lat() + '<br>' + 'LONGITUDE: ' + event.latLng.lng();

                });
                latitude = parseFloat(document.getElementById('returnedx').innerHTML);
                longitude = parseFloat(document.getElementById('returnedy').innerHTML);
                myLatLng = {lat: latitude, lng: longitude};
                if (document.getElementById('returnedx').innerHTML !== "" && document.getElementById('returnedy').innerHTML !== "") {
                    marker = new google.maps.Marker({
                        position: myLatLng,
                        map: map
//                        icon : 'http://maps.google.com/mapfiles/ms/icons/purple-dot.png'
                    });

                    document.getElementById('latLng').innerHTML = 'LATTITUDE: ' + latitude + '<br>' + 'LONGITUDE: ' + longitude;
                }
                north1 = parseFloat(document.getElementById('returnedx1').innerHTML);
                east1 = parseFloat(document.getElementById('returnedy1').innerHTML);
                south1 = parseFloat(document.getElementById('returnedx2').innerHTML);
                west1 = parseFloat(document.getElementById('returnedy2').innerHTML);
                if (document.getElementById('returnedx1').innerHTML !== "" && document.getElementById('returnedy1').innerHTML !== "" && f document.getElementById('returnedx2').innerHTML !== "" && document.getElementById('returnedy2').innerHTML !== ""){
                var bounds = {
                    north: north1,
                    south: south1,
                    east: east1,
                    west: west1
                };
                rectangle = new google.maps.Rectangle({
                    bounds: bounds,
                    editable: true,
                    draggable: true
                });}
                rectangle.setMap(map);
                rectangle.addListener('bounds_changed', showNewRect);
                document.getElementById('rectangledisplay').innerHTML = 'Rectangle Bounds : ' + '</br>' +
                        'North-East : ' + '</br>' + '     ' + rectangle.getBounds().getNorthEast().lat().toFixed(7) + ', ' + rectangle.getBounds().getNorthEast().lng().toFixed(7) + '<br>' +
                        'South-West : ' + '</br>' + '     ' + rectangle.getBounds().getSouthWest().lat().toFixed(7) + ', ' + rectangle.getBounds().getSouthWest().lng().toFixed(7);
            }

            function showNewRect(event) {
                var ne = rectangle.getBounds().getNorthEast();
                var sw = rectangle.getBounds().getSouthWest();
                document.getElementById('rectangledisplay').innerHTML = 'Rectangle Bounds : ' + '</br>' +
                        'North-East : ' + '</br>' + '     ' + ne.lat().toFixed(7) + ', ' + ne.lng().toFixed(7) + '<br>' +
                        'South-West : ' + '</br>' + '     ' + sw.lat().toFixed(7) + ', ' + sw.lng().toFixed(7);
//                var contentString = '<b>Rectangle moved.</b><br>' +
//                        'New north-east corner: ' + '</br>' + '     ' + ne.lat() + ', ' + ne.lng() + '<br>' +
//                        'New south-west corner: ' + '</br>' + '     ' + sw.lat() + ', ' + sw.lng();
                var x1 = ne.lat();
                var y1 = ne.lng();
                var x2 = sw.lat();
                var y2 = sw.lng();
                document.form3.field3.value = x1;
                document.form3.field4.value = y1;
                document.form3.field5.value = x2;
                document.form3.field6.value = y2;
                document.form3.flag3.value = 3;
                // Set the info window's content and position.
//                infoWindow.setContent(contentString);
//                infoWindow.setPosition(ne);

//                infoWindow.open(map);
                    
            }
            function displayHelp() {
                var message = 'The Maps Application supports two features : ' +
                        '1) Clicking the x button will give you the nearest' +
                        '10 reference locations to the point marked by the marker. ' +
                        '2) Clicking the y button will give a count of all reference' +
                        'points which fall inside the marked rectangle.';
                alert(message);
            }
        </script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA3JIYqhkkez0y7SL29izy7T8SOCpC1_qo&signed_in=true&callback=initMap" async defer>////////////
        </script>
    </body>
</html>
