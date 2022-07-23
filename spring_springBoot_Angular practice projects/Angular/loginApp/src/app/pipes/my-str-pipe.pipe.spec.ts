import { MyStrPipePipe } from './my-str-pipe.pipe';

describe('MyStrPipePipe', () => {
  it('create an instance', () => {
    const pipe = new MyStrPipePipe();
    expect(pipe).toBeTruthy();
  });
});
