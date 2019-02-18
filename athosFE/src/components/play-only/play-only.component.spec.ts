import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayOnlyComponent } from './play-only.component';

describe('PlayOnlyComponent', () => {
  let component: PlayOnlyComponent;
  let fixture: ComponentFixture<PlayOnlyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlayOnlyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayOnlyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
