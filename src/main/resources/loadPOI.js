function helloFunction() {
    var xhttp = new XMLHttpRequest();
    var title = document.getElementsByName("title").item(0).value;
    var description = document.getElementsByName("description").item(0).value;
    var mailUser = document.getElementsByName("mailUser").item(0).value;
    var longitude = document.getElementsByName("longitude").item(0).value;
    var latitude = document.getElementsByName("latitude").item(0).value;
    var file = document.getElementById("file").files;
    var url = "localhost:8080/poi/add?title="+title+"&description="+description+"&mailUser="+mailUser+"&longitude="+longitude+"&latitude="+latitude+"&file="+file;

    //$.get(url, function(data) {  });

    $.ajax({
        url : url
    });
    /*xhttp.open("POST", url, true);
    xhttp.send();*/
}