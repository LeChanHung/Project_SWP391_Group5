<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href= "css/attendance.css" rel="stylesheet" type="text/css" />
    <title>Student Manegement</title>
  </head>
  <body>

    <div class="studentData">
        <form action="" id="form1">
            <input type="text" placeholder="Subject" id="name" required>
            <input type="text" placeholder="Lesson" id="rollNo" required>
            <input type="submit" value="Find" class="btn btn-warning">
            
        </form>
    </div>



        <table>
            <thead>
                <tr>
                    <th>#</th>
                    <th>Subject</th>            
                    <th>Lesson</th>
                    <th>Attendence</th>
                </tr> 
            </thead>
            <tbody id="tbody">

            </tbody>
        </table>
  
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="./student.js"></script>
  </body>
</html>