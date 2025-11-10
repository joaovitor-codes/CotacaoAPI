import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConversionService {

  private readonly apiUrl = 'http://localhost:8080/conversion';

  constructor(private http: HttpClient) { }

  public convertCurrency(origin: string, destination: string, amount: number): Observable<number> {

    const params = new HttpParams()
      .set('from', origin)
      .set('to', destination)
      .set('amount', amount.toString());

    return this.http.get<number>(this.apiUrl, {
      params: params,
      responseType: 'json'
    });
  }
}
