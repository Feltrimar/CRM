import Link from 'next/link';

export default function list() {
  return (
    <>
      <h1>List of Opportunities</h1>
      <h2>
        <Link href="/posts/dashboard">Back to home</Link>
      </h2>
    </>
  );
}