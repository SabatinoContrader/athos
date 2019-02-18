import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayTeamComponent } from './play-team.component';

describe('PlayTeamComponent', () => {
  let component: PlayTeamComponent;
  let fixture: ComponentFixture<PlayTeamComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlayTeamComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayTeamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
