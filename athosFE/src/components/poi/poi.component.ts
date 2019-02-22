import { Component, OnInit } from '@angular/core';
import { Poi } from 'src/models/Poi';
import { PoiService } from 'src/services/poi.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-poi',
  templateUrl: './poi.component.html',
  styleUrls: ['./poi.component.less']
})
export class PoiComponent implements OnInit {

  public tuttipoi : Array<Poi>;
  constructor(private router : Router, private poiService : PoiService) { }

  ngOnInit() {
    this.poiService.tuttipoi().subscribe(response => {this.tuttipoi = response});
  }

}
