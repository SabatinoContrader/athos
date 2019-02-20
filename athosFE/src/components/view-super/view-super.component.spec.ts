import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewSuperComponent } from './view-super.component';

describe('ViewSuperComponent', () => {
  let component: ViewSuperComponent;
  let fixture: ComponentFixture<ViewSuperComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewSuperComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewSuperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
