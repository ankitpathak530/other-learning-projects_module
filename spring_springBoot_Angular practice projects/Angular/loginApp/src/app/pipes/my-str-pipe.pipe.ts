import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'myStrPipe'
})
export class MyStrPipePipe implements PipeTransform {

  transform(items: string[], searchText: string): string[] {

    if (!items) {
      return [];
    }
    if (!searchText) {
      return items;
    }

    searchText = searchText.toLocaleLowerCase();

    return items.filter(it => {
      return it.toLocaleLowerCase().includes(searchText);
    });



  }

}
