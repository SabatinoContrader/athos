import { Component, OnInit } from '@angular/core';
import { Sponsor } from 'src/models/Sponsor';
import { SponsorService } from 'src/services/sponsor.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sponsor',
  templateUrl: './sponsor.component.html',
  styleUrls: ['./sponsor.component.less']
})
export class SponsorComponent implements OnInit {

  public tuttisponsor : Array<Sponsor>;
  constructor(private router : Router, private sponsorService : SponsorService) { }

  ngOnInit() {
    this.sponsorService.tuttisponsor().subscribe(response => {this.tuttisponsor = response});
  }

}
