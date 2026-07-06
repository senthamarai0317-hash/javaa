import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class hotelserver {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(5000), 0);

        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {

                String html = """
<!DOCTYPE html>
<html>
<head>
<title>Hotel Management System</title>

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:Arial,sans-serif;
}

body{
background:#f5f5f5;
}

header{
background:#2c3e50;
color:white;
padding:20px 50px;
display:flex;
justify-content:space-between;
align-items:center;
}

nav a{
color:white;
text-decoration:none;
margin-left:20px;
}

.hero{
background:url('https://images.unsplash.com/photo-1566073771259-6a8506099945?w=1200') center/cover;
height:500px;
color:white;
text-align:center;
padding-top:150px;
}

.hero h1{
font-size:60px;
}

.hero p{
font-size:22px;
margin:20px;
}

.btn{
background:#e67e22;
color:white;
padding:15px 30px;
text-decoration:none;
border-radius:5px;
}

.rooms{
padding:50px;
display:flex;
justify-content:center;
gap:30px;
flex-wrap:wrap;
}

.card{
width:300px;
background:white;
border-radius:10px;
overflow:hidden;
box-shadow:0 0 10px rgba(0,0,0,0.2);
}

.card img{
width:100%;
height:200px;
}

.card-content{
padding:20px;
}

.features{
background:#34495e;
color:white;
padding:50px;
text-align:center;
}

.feature-box{
display:inline-block;
margin:20px;
}

footer{
background:#2c3e50;
color:white;
text-align:center;
padding:20px;
}

</style>

</head>

<body>

<header>
<h2>Royal Stay Hotel</h2>

<nav>
<a href="#">Home</a>
<a href="#">Rooms</a>
<a href="#">Booking</a>
<a href="#">Contact</a>
</nav>

</header>

<section class="hero">

<h1>Welcome to Royal Stay Hotel</h1>

<p>Luxury Rooms • Premium Services • Best Prices</p>

<a class="btn" href="#">Book Now</a>

</section>

<section class="rooms">

<div class="card">

<img src="https://images.unsplash.com/photo-1631049307264-da0ec9d70304?w=500">

<div class="card-content">
<h3>Deluxe Room</h3>
<p>King Size Bed, WiFi, AC, TV</p>
<h3>₹3,500 / Night</h3>
</div>

</div>

<div class="card">

<img src="https://images.unsplash.com/photo-1582719478250-c89cae4dc85b?w=500">

<div class="card-content">
<h3>Executive Suite</h3>
<p>Luxury Suite with Sea View</p>
<h3>₹6,000 / Night</h3>
</div>

</div>

<div class="card">

<img src="https://images.unsplash.com/photo-1566665797739-1674de7a421a?w=500">

<div class="card-content">
<h3>Family Room</h3>
<p>Perfect for Family Vacations</p>
<h3>₹5,000 / Night</h3>
</div>

</div>

</section>

<section class="features">

<div class="feature-box">
<h2>100+</h2>
<p>Luxury Rooms</p>
</div>

<div class="feature-box">
<h2>24/7</h2>
<p>Customer Support</p>
</div>

<div class="feature-box">
<h2>5000+</h2>
<p>Happy Guests</p>
</div>

</section>

<footer>

<p>© 2026 Royal Stay Hotel Management System</p>

</footer>

</body>
</html>
""";

                exchange.getResponseHeaders().add("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, html.getBytes().length);

                OutputStream os = exchange.getResponseBody();
                os.write(html.getBytes());
                os.close();
            }
        });

        server.setExecutor(null);
        server.start();

        System.out.println("Server started...");
        System.out.println("http://localhost:5000");
    }
}
