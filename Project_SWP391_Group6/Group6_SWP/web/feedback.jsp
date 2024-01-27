<!DOCTYPE html>
<html>
    <head>
        <title>Feedback form for Student</title>
        <link rel="stylesheet" type="text/css" href="style.css">   
        <link href= "css/feedback.css" rel="stylesheet" type="text/css" />
        
    </head>
    <body>
        <section></section>
        <form  action="feedback" method="post">

            <div class="container">
                <form>
                    <h1>Write your Feedback</h1>
                    <div class="id">
                         <input type="hidden" name="feedback_ID" value="f_id">
                        <input name="fullName" type="text" placeholder="Full name">

                    </div>
                    <div class="id">
                        <input name="email" type="email" placeholder="Email address">

                    </div>
                    <textarea name="feedback" cols="15" rows="5" placeholder="Write your Feedback here.."></textarea>

                    <button>Send</button>
                </form>
            </div>
        </form>

    </body>
</html>

