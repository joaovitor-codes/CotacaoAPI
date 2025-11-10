import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ConversionService } from './conversion';
import { HttpErrorResponse } from '@angular/common/http';

export interface Currency {
  code: string;
  name: string;
}

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    FormsModule,
    CommonModule
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class AppComponent {

  public amount: number = 100;
  public originCurrency: string = 'USD';
  public destinationCurrency: string = 'BRL';

  public convertedAmount: number | null = null;
  public errorMessage: string | null = null;

  public availableCurrencies: Currency[] = [
    { code: 'AFN', name: 'Afghani do Afeganistão' },
    { code: 'MGA', name: 'Ariary Madagascarense' },
    { code: 'THB', name: 'Baht Tailandês' },
    { code: 'PAB', name: 'Balboa Panamenho' },
    { code: 'BNB', name: 'Binance Coin' },
    { code: 'ETB', name: 'Birr Etíope' },
    { code: 'VEF', name: 'Bolívar Venezuelano' },
    { code: 'BOB', name: 'Boliviano' },
    { code: 'XBR', name: 'Brent Spot' },
    { code: 'BRETT', name: 'Brett' },
    { code: 'GHS', name: 'Cedi Ganês' },
    { code: 'SVC', name: 'Colon de El Salvador' },
    { code: 'CRC', name: 'Colón Costarriquenho' },
    { code: 'CZK', name: 'Coroa Checa' },
    { code: 'DKK', name: 'Coroa Dinamarquesa' },
    { code: 'ISK', name: 'Coroa Islandesa' },
    { code: 'NOK', name: 'Coroa Norueguesa' },
    { code: 'SEK', name: 'Coroa Sueca' },
    { code: 'NIO', name: 'Córdoba Nicaraguense' },
    { code: 'GMD', name: 'Dalasi da Gâmbia' },
    { code: 'MKD', name: 'Denar Macedônio' },
    { code: 'DZD', name: 'Dinar Argelino' },
    { code: 'BHD', name: 'Dinar do Bahrein' },
    { code: 'IQD', name: 'Dinar Iraquiano' },
    { code: 'JOD', name: 'Dinar Jordaniano' },
    { code: 'KWD', name: 'Dinar Kuwaitiano' },
    { code: 'LYD', name: 'Dinar Líbio' },
    { code: 'RSD', name: 'Dinar Sérvio' },
    { code: 'TND', name: 'Dinar Tunisiano' },
    { code: 'AED', name: 'Dirham dos Emirados' },
    { code: 'MAD', name: 'Dirham Marroquino' },
    { code: 'STD', name: 'Dobra São Tomé/Príncipe' },
    { code: 'DOGE', name: 'Dogecoin' },
    { code: 'VND', name: 'Dong Vietnamita' },
    { code: 'USD', name: 'Dólar Americano' },
    { code: 'USDT', name: 'Dólar Americano' },
    { code: 'AUD', name: 'Dólar Australiano' },
    { code: 'CAD', name: 'Dólar Canadense' },
    { code: 'BSD', name: 'Dólar das Bahamas' },
    { code: 'KYD', name: 'Dólar das Ilhas Cayman' },
    { code: 'BBD', name: 'Dólar de Barbados' },
    { code: 'BZD', name: 'Dólar de Belize' },
    { code: 'BND', name: 'Dólar de Brunei' },
    { code: 'SGD', name: 'Dólar de Cingapura' },
    { code: 'FJD', name: 'Dólar de Fiji' },
    { code: 'HKD', name: 'Dólar de Hong Kong' },
    { code: 'TTD', name: 'Dólar de Trinidad' },
    { code: 'XCD', name: 'Dólar do Caribe Oriental' },
    { code: 'NAD', name: 'Dólar Namíbio' },
    { code: 'NZD', name: 'Dólar Neozelandês' },
    { code: 'TWD', name: 'Dólar Taiuanês' },
    { code: 'ZWL', name: 'Dólar Zimbabuense' },
    { code: 'AMD', name: 'Dram Armênio' },
    { code: 'SDR', name: 'DSE' },
    { code: 'CVE', name: 'Escudo cabo-verdiano' },
    { code: 'ETH', name: 'Ethereum' },
    { code: 'EUR', name: 'Euro' },
    { code: 'HUF', name: 'Florim Húngaro' },
    { code: 'KMF', name: 'Franco Comorense' },
    { code: 'GNF', name: 'Franco de Guiné' },
    { code: 'DJF', name: 'Franco do Djubouti' },
    { code: 'RWF', name: 'Franco Ruandês' },
    { code: 'CHF', name: 'Franco Suíço' },
    { code: 'CHFRTS', name: 'Franco Suíço' },
    { code: 'XAF', name: 'Franco CFA Central' },
    { code: 'XOF', name: 'Franco CFA Ocidental' },
    { code: 'XPF', name: 'Franco CFP' },
    { code: 'HTG', name: 'Gourde Haitiano' },
    { code: 'PYG', name: 'Guarani Paraguaio' },
    { code: 'ANG', name: 'Guilder das Antilhas' },
    { code: 'UAH', name: 'Hryvinia Ucraniana' },
    { code: 'JPY', name: 'Iene Japonês' },
    { code: 'JPYRTS', name: 'Iene Japonês' },
    { code: 'PGK', name: 'Kina Papua-Nova Guiné' },
    { code: 'LAK', name: 'Kip Laosiano' },
    { code: 'HRK', name: 'Kuna Croata' },
    { code: 'MWK', name: 'Kwacha Malauiana' },
    { code: 'ZMK', name: 'Kwacha Zambiana' },
    { code: 'AOA', name: 'Kwanza Angolano' },
    { code: 'MMK', name: 'Kyat de Mianmar' },
    { code: 'GEL', name: 'Lari Georgiano' },
    { code: 'ALL', name: 'Lek Albanês' },
    { code: 'HNL', name: 'Lempira Hondurenha' },
    { code: 'MDL', name: 'Leu Moldavo' },
    { code: 'RON', name: 'Leu Romeno' },
    { code: 'BGN', name: 'Lev Búlgaro' },
    { code: 'SYP', name: 'Libra Síria' },
    { code: 'EGP', name: 'Libra Egípcia' },
    { code: 'GBP', name: 'Libra Esterlina' },
    { code: 'LBP', name: 'Libra Libanesa' },
    { code: 'SDG', name: 'Libra Sudanesa' },
    { code: 'SZL', name: 'Lilangeni Suazilandês' },
    { code: 'LTC', name: 'Litecoin' },
    { code: 'LSL', name: 'Loti do Lesoto' },
    { code: 'AZN', name: 'Manat Azeri' },
    { code: 'BAM', name: 'Marco Conversível' },
    { code: 'MZN', name: 'Metical de Moçambique' },
    { code: 'MNT', name: 'Mongolian Tugrik' },
    { code: 'NGN', name: 'Naira Nigeriana' },
    { code: 'NGNI', name: 'Naira Nigeriana' },
    { code: 'NGNPARALLEL', name: 'Naira Nigeriana' },
    { code: 'TRY', name: 'Nova Lira Turca' },
    { code: 'ILS', name: 'Novo Shekel Israelense' },
    { code: 'MRO', name: 'Ouguiya Mauritana' },
    { code: 'XAU', name: 'Ouro' },
    { code: 'MOP', name: 'Pataca de Macau' },
    { code: 'ARS', name: 'Peso Argentino' },
    { code: 'CLP', name: 'Peso Chileno' },
    { code: 'COP', name: 'Peso Colombiano' },
    { code: 'CUP', name: 'Peso Cubano' },
    { code: 'DOP', name: 'Peso Dominicano' },
    { code: 'PHP', name: 'Peso Filipino' },
    { code: 'MXN', name: 'Peso Mexicano' },
    { code: 'UYU', name: 'Peso Uruguai' },
    { code: 'XAGG', name: 'Prata' },
    { code: 'XAG', name: 'Prata Spot' },
    { code: 'BWP', name: 'Pula de Botswana' },
    { code: 'GTQ', name: 'Quetzal Guatemalteco' },
    { code: 'ZAR', name: 'Rand Sul-Africano' },
    { code: 'BRL', name: 'Real Brasileiro' },
    { code: 'BRLT', name: 'Real Brasileiro Turismo' },
    { code: 'BRLPTAX', name: 'Real Brasileiro' },
    { code: 'QAR', name: 'Rial Catarense' },
    { code: 'IRR', name: 'Rial Iraniano' },
    { code: 'YER', name: 'Riyal Iemenita' },
    { code: 'OMR', name: 'Rial Omanense' },
    { code: 'KHR', name: 'Riel Cambojano' },
    { code: 'MYR', name: 'Ringgit Malaio' },
    { code: 'RUB', name: 'Rublo Russo' },
    { code: 'RUBTOD', name: 'Rublo Russo' },
    { code: 'RUBTOM', name: 'Rublo Russo' },
    { code: 'BYN', name: 'Rublo Bielorrusso' },
    { code: 'MVR', name: 'Rufiyaa Maldiva' },
    { code: 'IDR', name: 'Rupia Indonésia' },
    { code: 'INR', name: 'Rúpia Indiana' },
    { code: 'LKR', name: 'Rúpia de Sri Lanka' },
    { code: 'MUR', name: 'Rúpia Mauriciana' },
    { code: 'NPR', name: 'Rúpia Nepalesa' },
    { code: 'PKR', name: 'Rúpia Paquistanesa' },
    { code: 'SCR', name: 'Rúpias de Seicheles' },
    { code: 'SAR', name: 'Riyal Saudita' },
    { code: 'KES', name: 'Shilling Queniano' },
    { code: 'SOS', name: 'Shilling Somaliano' },
    { code: 'TZS', name: 'Shilling Tanzaniano' },
    { code: 'UGX', name: 'Shilling Ugandês' },
    { code: 'SOL', name: 'Sol' },
    { code: 'PEN', name: 'Sol do Peru' },
    { code: 'SOL', name: 'Solana' },
    { code: 'KGS', name: 'Som Quirguistanês' },
    { code: 'UZS', name: 'Som Uzbequistanês' },
    { code: 'TJS', name: 'Somoni do Tajiquistão' },
    { code: 'BDT', name: 'Taka de Bangladesh' },
    { code: 'KZT', name: 'Tengue Cazaquistanês' },
    { code: 'TMT', name: 'TMT' },
    { code: 'VUV', name: 'Vatu de Vanuatu' },
    { code: 'KRW', name: 'Won Sul-Coreano' },
    { code: 'XRP', name: 'XRP' }, // Correção do 'code_' para 'code'
    { code: 'CNH', name: 'Yuan chinês offshore' },
    { code: 'CNY', name: 'Yuan Chinês' },
    { code: 'PLN', name: 'Zlóti Polonês' }
  ];

  constructor(private conversionService: ConversionService) { }

  public convertCurrency(): void {
    this.convertedAmount = null;
    this.errorMessage = null;

    if (!this.amount || !this.originCurrency || !this.destinationCurrency) {
      this.errorMessage = "Por favor, preencha todos os campos.";
      return;
    }

    this.conversionService.convertCurrency(
      this.originCurrency, // O service vai converter para 'from'
      this.destinationCurrency, // O service vai converter para 'to'
      this.amount
    ).subscribe({

      next: (response: number) => {
        this.convertedAmount = response;
      },

      error: (err: HttpErrorResponse) => {

        console.error('Erro completo recebido:', err);

        if (err.status === 0) {
          this.errorMessage = "Não foi possível conectar ao servidor. O backend está online?";
        }
        else if (err.status === 404 || err.status === 400) {

          if (err.error && err.error.message) {
            this.errorMessage = err.error.message;
          } else {
            this.errorMessage = `Erro ${err.status}: A resposta do servidor não foi formatada corretamente.`;
          }
        }
        else {
          this.errorMessage = `Erro inesperado: ${err.status}. Tente novamente mais tarde.`;
        }
      }
    });
  }

}
