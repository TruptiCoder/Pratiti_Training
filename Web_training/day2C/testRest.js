function testRest() {
    fetch("http://192.168.1.85:1234/employee/trupti/id/1232", {
        method: "POST"
    })
    .then(response => response.text())
    .then((data) => {
        console.log("Data:", data);
    })
    .catch((err) => {
        console.log("Err: ", err)
    })
}

testRest()