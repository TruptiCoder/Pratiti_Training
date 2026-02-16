import { Component } from "@angular/core";
import { Shweta } from "./shweta";

@Component({
    selector: "app-trupti",
    templateUrl: "./trupti.html",
    styleUrl: "../app.css",
    imports: [Shweta]
})
export class Trupti {
    fname = "Trupti";
    lname = "Balbudhe";
}