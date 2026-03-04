import { useEffect, useState } from "react";
import API from "./services/api";

function App() {
  const [message, setMessage] = useState("Checking connection...");

  useEffect(() => {
    API.get("/person")
      .then((res) => {
        setMessage("✅ Connected to Backend!");
        console.log(res.data);
      })
      .catch((err) => {
        console.error(err);
        setMessage("❌ Failed to connect to Backend");
      });
  }, []);

  return (
    <div style={{ padding: "40px" }}>
      <h1>Music Recommendation Engine</h1>
      <p>{message}</p>
    </div>
  );
}

export default App;