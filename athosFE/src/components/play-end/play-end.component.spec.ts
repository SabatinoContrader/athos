import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayEndComponent } from './play-end.component';

describe('PlayEndComponent', () => {
  let component: PlayEndComponent;
  let fixture: ComponentFixture<PlayEndComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlayEndComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayEndComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
