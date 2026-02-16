import { Component } from "@angular/core";

@Component({
    selector: "app-shweta",
    template: "<h1 class='shweta'>Hello, {{fname}}</h1>",
    styleUrl: "../app.css",
    // styles: ".shweta{background-color: red}"
})
export class Shweta {
    fname = "Shweta";
}