import axios from "axios";
import { useEffect, useState } from "react";

function Home({ setIsLogedIn, currUser }) {
  const [data, setData] = useState({ username: "", email: "" });
  const username = currUser;

  useEffect(() => {
    const fetchData = async () => {
      try {
        if (username) {
          const res = await axios.get(
            `http://192.168.1.75:5050/users/${username}`,
          );
          const d = res.data;
          setData(d);
        }
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };

    fetchData();
    if(currUser) setIsLogedIn(true);
  }, [username]);

  return (
    <div className="m-5 p-5 d-flex align-items-center justify-content-center flex-column">
      {currUser ? (
        <div className="text-center">
          <h1>Welcome to MyApp</h1>
          <p>
            username: {data.username} | email: {data.email}
          </p>
        </div>
      ) : (
        <div className="text-center">
          <h1>Please Login!</h1>
          <p>You can not access this page without login</p>
        </div>
      )}
    </div>
  );
}

export default Home;
